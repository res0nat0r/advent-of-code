(comment "
You start on the open square (.) in the top-left corner and need to reach the
bottom (below the bottom-most row on your map).

The toboggan can only follow a few specific slopes (you opted for a cheaper
model that prefers rational numbers); start by counting all the trees you
would encounter for the slope right 3, down 1:

From your starting position at the top-left, check the position that is right
3 and down 1. Then, check the position that is right 3 and down 1 from there,
and so on until you go past the bottom of the map.
")

(ns p003.core
  (:gen-class))

(require '[clojure.string :as str])

(def input
    (map #(str/split % #" ") (str/split (slurp "resources/input.txt") #"\n")))

(defn -main [& _]
)