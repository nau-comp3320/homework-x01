(ns homework-x01.infix-test
  (:require [clojure.test :refer :all]
            [clojure.walk :refer [macroexpand-all]]
            [homework-x01.infix :refer [infix]]))

(deftest test-infix
  (testing "Basic x op y expressions"
    (testing "correct macro-expansion"
      (is (= '(+ 1 1) (macroexpand '(infix 1 + 1))))
      (is (= '(* 3 5) (macroexpand '(infix 3 * 5)))))
    (testing "evaluation"
      (is (= 2 (infix 1 + 1)))
      (is (= 15 (infix 3 * 5)))))
  (testing "Recursive (x) op y expressions"
    (testing "correct macro-expansion"
      (is (= '(+ (homework-x01.infix/infix 1 - 2) 3) (macroexpand '(infix (1 - 2) + 3))))
      (is (= '(+ (- 1 2) 3) (macroexpand-all '(infix (1 - 2) + 3))))
      (is (= '(* (homework-x01.infix/infix (1 * 2) + 3) 4) (macroexpand '(infix ((1 * 2) + 3) * 4))))
      (is (= '(* (+ (* 1 2) 3) 4) (macroexpand-all '(infix ((1 * 2) + 3) * 4)))))
    (testing "evaluation"
      (is (= 2 (infix (1 - 2) + 3)))
      (is (= 20 (infix ((1 * 2) + 3) * 4)))))
  (testing "Recursive x op (y) expressions"
    (testing "correct macro-expansion"
      (is (= '(-  1 (homework-x01.infix/infix 2 + 3)) (macroexpand '(infix 1 - (2 + 3)))))
      (is (= '(- 1 (+ 2 3)) (macroexpand-all '(infix 1 - (2 + 3)))))
      (is (= '(* 1 (homework-x01.infix/infix 2 + (3 * 4))) (macroexpand '(infix 1 * (2 + (3 * 4))))))
      (is (= '(* 1 (+ 2 (* 3 4))) (macroexpand-all '(infix 1 * (2 + (3 * 4)))))))
    (testing "evaluation"
      (is (= -4 (infix 1 - (2 + 3))))
      (is (= 14 (infix 1 * (2 + (3 * 4)))))))
  (testing "Recursive (x) op (y) expressions"
    (testing "correct macro-expansion"
      (is (= '(- (homework-x01.infix/infix 1 * 2) (homework-x01.infix/infix 3 + 4))
             (macroexpand '(infix (1 * 2) - (3 + 4)))))
      (is (= '(- (* 1 2) (+ 3 4))
             (macroexpand-all '(infix (1 * 2) - (3 + 4)))))
      (is (= '(+ (homework-x01.infix/infix (1 * 2) - (3 + 4))
                 (homework-x01.infix/infix (5 * 6) - (7 + 8)))
             (macroexpand '(infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8))))))
      (is (= '(+ (- (* 1 2) (+ 3 4))
                 (- (* 5 6) (+ 7 8)))
             (macroexpand-all '(infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8)))))))
    (testing "evaluation"
      (is (= -5 (infix (1 * 2) - (3 + 4))))
      (is (= 10 (infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8))))))))
