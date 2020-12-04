(ns p001.core-test
  (:require [clojure.test :refer :all]
            [p001.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest pairs-of-values
  (let [args ["--server" "localhost" "--port" "8080"]]
    (is (= {:server "localhost" :port "8080"}
           (parse-args args)))))

