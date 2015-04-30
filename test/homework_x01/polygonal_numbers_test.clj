(ns homework-x01.polygonal-numbers-test
  (:require [clojure.test :refer :all]
            [homework-x01.polygonal-numbers :as poly]))

(deftest test-polygonal-number
  (testing "triangle numbers"
    (is (= 0 (poly/polygonal-number 3 0)))
    (is (= 1 (poly/polygonal-number 3 1)))
    (is (= 3 (poly/polygonal-number 3 2)))
    (is (= 6 (poly/polygonal-number 3 3)))
    (is (= 10 (poly/polygonal-number 3 4)))
    (is (= 15 (poly/polygonal-number 3 5)))
    (is (= 55 (poly/polygonal-number 3 10))))
  (testing "square numbers"
    (is (= 0 (poly/polygonal-number 4 0)))
    (is (= 1 (poly/polygonal-number 4 1)))
    (is (= 4 (poly/polygonal-number 4 2)))
    (is (= 9 (poly/polygonal-number 4 3)))
    (is (= 16 (poly/polygonal-number 4 4)))
    (is (= 25 (poly/polygonal-number 4 5)))
    (is (= 100 (poly/polygonal-number 4 10))))
  (testing "pentagonal numbers"
    (is (= 0 (poly/polygonal-number 5 0)))
    (is (= 1 (poly/polygonal-number 5 1)))
    (is (= 5 (poly/polygonal-number 5 2)))
    (is (= 12 (poly/polygonal-number 5 3)))
    (is (= 22 (poly/polygonal-number 5 4)))
    (is (= 35 (poly/polygonal-number 5 5)))
    (is (= 145 (poly/polygonal-number 5 10))))
  (testing "dodecagonal numbers"
    (is (= 0 (poly/polygonal-number 12 0)))
    (is (= 1 (poly/polygonal-number 12 1)))
    (is (= 12 (poly/polygonal-number 12 2)))
    (is (= 33 (poly/polygonal-number 12 3)))
    (is (= 64 (poly/polygonal-number 12 4)))
    (is (= 105 (poly/polygonal-number 12 5)))
    (is (= 460 (poly/polygonal-number 12 10))))
  (testing "myriagonal numbers"
    (is (= 0 (poly/polygonal-number 10000 0)))
    (is (= 1 (poly/polygonal-number 10000 1)))
    (is (= 10000 (poly/polygonal-number 10000 2)))
    (is (= 29997 (poly/polygonal-number 10000 3)))
    (is (= 59992 (poly/polygonal-number 10000 4)))
    (is (= 99985 (poly/polygonal-number 10000 5)))
    (is (= 449920 (poly/polygonal-number 10000 10)))))

(deftest test-polygonal-seq
  (testing "triangle numbers"
    (is (= [0 1 3 6 10 15] (take 6 (poly/polygonal-seq 3))))
    (is (= [5050 5151 5253 5356 5460] (take 5 (drop 100 (poly/polygonal-seq 3)))))
    (is (= [500500 501501 502503 503506 504510] (take 5 (drop 1000 (poly/polygonal-seq 3))))))
  (testing "square numbers"
    (is (= [0 1 4 9 16 25] (take 6 (poly/polygonal-seq 4))))
    (is (= [10000 10201 10404 10609 10816] (take 5 (drop 100 (poly/polygonal-seq 4)))))
    (is (= [1000000 1002001 1004004 1006009 1008016] (take 5 (drop 1000 (poly/polygonal-seq 4))))))
  (testing "square numbers"
    (is (= [0 1 4 9 16 25] (take 6 (poly/polygonal-seq 4))))
    (is (= [10000 10201 10404 10609 10816] (take 5 (drop 100 (poly/polygonal-seq 4)))))
    (is (= [1000000 1002001 1004004 1006009 1008016] (take 5 (drop 1000 (poly/polygonal-seq 4))))))
  (testing "pentagonal numbers"
    (is (= [0 1 5 12 22 35] (take 6 (poly/polygonal-seq 5))))
    (is (= [14950 15251 15555 15862 16172] (take 5 (drop 100 (poly/polygonal-seq 5)))))
    (is (= [1499500 1502501 1505505 1508512 1511522] (take 5 (drop 1000 (poly/polygonal-seq 5))))))
  (testing "dodecagonal numbers"
    (is (= [0 1 12 33 64 105] (take 6 (poly/polygonal-seq 12))))
    (is (= [49600 50601 51612 52633 53664] (take 5 (drop 100 (poly/polygonal-seq 12)))))
    (is (= [4996000 5006001 5016012 5026033 5036064] (take 5 (drop 1000 (poly/polygonal-seq 12))))))
  (testing "myriagonal numbers"
    (is (= [0 1 10000 29997 59992 99985] (take 6 (poly/polygonal-seq 10000))))
    (is (= [49490200 50490001 51499800 52519597 53549392] (take 5 (drop 100 (poly/polygonal-seq 10000)))))
    (is (= [4994002000 5004000001 5014008000 5024025997 5034053992] (take 5 (drop 1000 (poly/polygonal-seq 10000)))))))
