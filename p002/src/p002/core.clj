(comment "
- Part One:

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
Each line gives the password policy and then the password. The password policy
         indicates the lowest and highest number of times a given letter must
         appear for the password to be valid. For example, 1-3 a means that the
         password must contain a at least 1 time and at most 3 times.

In the above example, 2 passwords are valid. The middle password, cdefg, is
         not; it contains no instances of b, but needs at least 1. The first
         and third passwords are valid: they contain one a or nine c, both
         within the limits of their respective policies.

- Part Two:

         Each policy actually describes two positions in the password, where 1
         means the first character, 2 means the second character, and so on.
         (Be careful; Toboggan Corporate Policies have no concept of 'index
         zero'!) Exactly one of these positions must contain the given letter.
         Other occurrences of the letter are irrelevant for the purposes of policy
         enforcement.

Given the same example list from above:

1-3 a: abcde is valid: position 1 contains a and position 3 does not.
1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
")

(ns p002.core
  (:gen-class))

(require '[clojure.string :as str])

(def input
    (map #(str/split % #" ") (str/split (slurp "resources/input.txt") #"\n")))

(def parse-input
  (for [line input
        :let [lowhigh (str/split (first line) #"-")
              low (first lowhigh)
              high (last lowhigh)
              chr (str/replace (second line) #":" "")
              passwd (last line)
              char-count (get-in (frequencies passwd) chr 0)]]

    {:low (Integer/parseInt low) :high (Integer/parseInt high) :chr chr :char-count char-count :passwd passwd}))

(def passwords-in-range
  (for [line parse-input
        :let [low (get line :low)
              high (get line :high)
              chr (get line :char-count)]]

    (if 
      (and (>= chr low) (<= chr high)) 1 0)))

(def exactly-one-match
  (for [line parse-input
        :let [low (get line :low)
              high (get line :high)
              chr (get line :chr)
              passwd (get line :passwd)
              low-match (= chr (str (get passwd (dec low))))
              high-match (= chr (str (get passwd (dec high))))
              true-count (get (frequencies [low-match high-match]) true)]]

    (if (= 1 true-count) 1 0)))

(defn -main [& _]
  (println (apply + passwords-in-range))
  (println (apply + exactly-one-match)))
