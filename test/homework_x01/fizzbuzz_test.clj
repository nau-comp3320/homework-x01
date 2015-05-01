(ns homework-x01.fizzbuzz-test
  (:require [clojure.test :refer :all]
            [homework-x01.fizzbuzz :refer [fizzbuzz]]))

(deftest test-fizzbuzz
  (testing "regular numbers"
    (is (= 1 (fizzbuzz 1)))
    (is (= 2 (fizzbuzz 2)))
    (is (= 4 (fizzbuzz 4)))
    (is (= 7 (fizzbuzz 7))))
  (testing "fizz"
    (is (= :fizz! (fizzbuzz 3)))
    (is (= :fizz! (fizzbuzz 6)))
    (is (= :fizz! (fizzbuzz 9))))
  (testing "buzz"
    (is (= :buzz! (fizzbuzz 5)))
    (is (= :buzz! (fizzbuzz 10)))
    (is (= :buzz! (fizzbuzz 20))))
  (testing "fizzbuzz"
    (is (= :fizzbuzz! (fizzbuzz 15)))
    (is (= :fizzbuzz! (fizzbuzz 30)))
    (is (= :fizzbuzz! (fizzbuzz 45)))))
