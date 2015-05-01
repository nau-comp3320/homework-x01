(ns homework-x01.bowling-test
  (:require [clojure.test :refer :all]
            [homework-x01.bowling :refer :all]))

(defn score-game
  [rolls]
  (score (reduce roll (new-game) rolls)))

(deftest bowling-kata
  (testing "gutter game"
    (is (= 0 (score-game (repeat 20 0)))))
  (testing "all ones"
    (is (= 20 (score-game (repeat 20 1)))))
  (testing "one spare"
    (is (= 16 (score-game (concat [5 5 3]
                                  (repeat 17 0))))))
  (testing "one strike"
    (is (= 26 (score-game (concat [10 5 3]
                                  (repeat 16 0))))))
  (testing "perfect game"
    (is (= 300 (score-game (repeat 12 10))))))
