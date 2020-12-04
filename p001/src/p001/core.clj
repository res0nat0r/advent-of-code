(ns p001.core
  (:gen-class))

;  Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.
;  In your expense report, what is the product of the three entries that sum to 2020?

(require '[clojure.string :as str])
(require '[clojure.math.combinatorics :as c])

(defn parse-input [i]
  (->> i
       (map str)
       (map clojure.edn/read-string)))

(def input (parse-input (str/split (slurp "resources/001.txt") #"\n")))
(def pairs (c/combinations input 2))
(def triples (c/combinations input 3))

(defn sum-to-2020? [x]
  (= 2020 (apply + x)))

(defn -main [& _]
  (println (apply * (first (filter sum-to-2020? pairs))))
  (println (apply * (first (filter sum-to-2020? triples)))))
