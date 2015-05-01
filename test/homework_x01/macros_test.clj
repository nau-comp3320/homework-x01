(ns homework-x01.macros-test
  (:require [clojure.test :refer :all]
            [clojure.walk :refer [macroexpand-all]]
            [homework-x01.macros :as m]))

(deftest test-infix
  (testing "Basic x op y expressions"
    (testing "correct macro-expansion"
      (is (= '(+ 1 1) (macroexpand '(m/infix 1 + 1))))
      (is (= '(* 3 5) (macroexpand '(m/infix 3 * 5)))))
    (testing "evaluation"
      (is (= 2 (m/infix 1 + 1)))
      (is (= 15 (m/infix 3 * 5)))))
  (testing "Recursive (x) op y expressions"
    (testing "correct macro-expansion"
      (is (= '(+ (homework-x01.macros/infix 1 - 2) 3) (macroexpand '(m/infix (1 - 2) + 3))))
      (is (= '(+ (- 1 2) 3) (macroexpand-all '(m/infix (1 - 2) + 3))))
      (is (= '(* (homework-x01.macros/infix (1 * 2) + 3) 4) (macroexpand '(m/infix ((1 * 2) + 3) * 4))))
      (is (= '(* (+ (* 1 2) 3) 4) (macroexpand-all '(m/infix ((1 * 2) + 3) * 4)))))
    (testing "evaluation"
      (is (= 2 (m/infix (1 - 2) + 3)))
      (is (= 20 (m/infix ((1 * 2) + 3) * 4)))))
  (testing "Recursive x op (y) expressions"
    (testing "correct macro-expansion"
      (is (= '(-  1 (homework-x01.macros/infix 2 + 3)) (macroexpand '(m/infix 1 - (2 + 3)))))
      (is (= '(- 1 (+ 2 3)) (macroexpand-all '(m/infix 1 - (2 + 3)))))
      (is (= '(* 1 (homework-x01.macros/infix 2 + (3 * 4))) (macroexpand '(m/infix 1 * (2 + (3 * 4))))))
      (is (= '(* 1 (+ 2 (* 3 4))) (macroexpand-all '(m/infix 1 * (2 + (3 * 4)))))))
    (testing "evaluation"
      (is (= -4 (m/infix 1 - (2 + 3))))
      (is (= 14 (m/infix 1 * (2 + (3 * 4)))))))
  (testing "Recursive (x) op (y) expressions"
    (testing "correct macro-expansion"
      (is (= '(- (homework-x01.macros/infix 1 * 2) (homework-x01.macros/infix 3 + 4))
             (macroexpand '(m/infix (1 * 2) - (3 + 4)))))
      (is (= '(- (* 1 2) (+ 3 4))
             (macroexpand-all '(m/infix (1 * 2) - (3 + 4)))))
      (is (= '(+ (homework-x01.macros/infix (1 * 2) - (3 + 4))
                 (homework-x01.macros/infix (5 * 6) - (7 + 8)))
             (macroexpand '(m/infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8))))))
      (is (= '(+ (- (* 1 2) (+ 3 4))
                 (- (* 5 6) (+ 7 8)))
             (macroexpand-all '(m/infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8)))))))
    (testing "evaluation"
      (is (= -5 (m/infix (1 * 2) - (3 + 4))))
      (is (= 10 (m/infix ((1 * 2) - (3 + 4)) + ((5 * 6) - (7 + 8))))))))
