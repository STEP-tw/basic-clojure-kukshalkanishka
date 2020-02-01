(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest map
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3])))))

(deftest filter-test
    (testing "even? predicate"
      (is (= [2 4 6] (filter' even? [1 2 3 4 5 6 9])))))

(deftest reduce-test
    (testing "arity 2"
      (is (= 15 (reduce' + [1 2 3 4 5]))))
    (testing "arity 3"
      (is (= 15 (reduce' + 1 [2 3 4 5])))))

(deftest count-test
    (testing "sequence length"
      (is (= 5 (count' [1 2 3 4 5]))))
    (testing "nil"
      (is (= 0 (count' nil))))
    (testing "[]"
      (is (= 0 (count' []))))
    (testing "map"
      (is (= 2 (count {:one 1 :two 2}))))
    (testing "string"
      (is (= 6 (count "abcdef")))))

(deftest reverse-test
  (testing "seqable collection"
    (is (= [5 4 3 2 1] (reverse' [1 2 3 4 5]))))
  (testing "non-seqable collection"
    (is (nil? (reverse' 1)))))

(deftest every-test
  (testing "true condition"
    (is (true? (every?' even? [2 4 6 8]))))
  (testing "false condition"
    (is (false? (every?' even? [2 4 9 6 8])))))

(deftest some-test
  (testing "true condition"
    (is (true? (some?' even? [1 5 3 4]))))
  (testing "false condition"
    (is (false? (some?' even? [1 5 7 9])))))

(deftest ascending-test
  (testing "true condition"
    (is (true? (ascending? [1 2 3 4 5 6]))))
  (testing "false condition"
    (is (false? (ascending? [1 2 3 2 1 0])))))

(deftest index-of-test
  (testing "element present in collection"
    (is (= 4 (index-of [1 2 3 4 5 6] 5))))
  (testing "element not-present in collection"
    (is (= -1 (index-of [1 2 3 4 5 6] 9)))))

(deftest palindrome?-test
  (testing "true condition"
    (is (true? (palindrome? ["n" "a" "m" "a" "n"]))))
  (testing "false condition"
    (is (false? (palindrome? ["k" "a" "n" "n" "u"])))))
