(ns homework-x01.infix-test
  (:require [clojure.test :refer :all]
            [clojure.walk :refer [macroexpand-all]]
            [homework-x01.infix :refer [infix]]))

(deftest test-infix
  (testing "Basic x op y expressions"
    (is (= 2 (infix 1 + 1)))
    (is (= 15 (infix 3 * 5))))
  (testing "Recursive (x) op y expressions"
    (is (= 2 (infix (1 - 2) + 3)))
    (is (= 20 (infix ((1 * 2) + 3) * 4))))
  (testing "Recursive x op (y) expressions"
    (is (= -4 (infix 1 - (2 + 3))))
    (is (= 14 (infix 1 * (2 + (3 * 4))))))
  (testing "Recursive (x) op (y) expressions"
    (is (= -5 (infix (1 * 2) - (3 + 4))))
    (is (= 10 (infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8)))))))
