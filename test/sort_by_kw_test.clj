(ns sort-by-kw-test
  (:require
   [clojure.test :refer [deftest
                         testing
                         is]]
   [sort-by-kw :as sut]))

(deftest keyword-comparator-test
  (testing "exists"
    (is sut/keyword-comparator))
  (testing "takes two inputs to compare"
    (is (sut/keyword-comparator [:high :low] :high :low)))
  (testing "compares keywords in collection"
    (is (= -1 (sut/keyword-comparator [:high :low] :high :low)))
    (is (= 1 (sut/keyword-comparator [:high :low] :low :high)))
    (is (= -1 (sut/keyword-comparator [:low :high] :low :high)))
    (is (= -1 (sut/keyword-comparator [:low] :low :high)))
    (is (= 1 (sut/keyword-comparator [:high] :low :high)))
    (is (= 0 (sut/keyword-comparator [:high] :low :low)))
    (is (= 0 (sut/keyword-comparator [] :low :low)))
    (is (= 0 (sut/keyword-comparator [:med] :low :low)))
    (is (= 0 (sut/keyword-comparator [:med] :low :high)))
    (is (= 1 (sut/keyword-comparator [:high :med :low] :low :high)))))

(deftest sort-by-kw-test
  (testing "exists"
    (is sut/sort-by-kw))
  (testing "returns collection when empty"
    (is (= []
           (sut/sort-by-kw []))))
  (testing "returns collection when only one item"
    (is (= [:test]
           (sut/sort-by-kw [:test]))))
  (testing "sorts collection"
    (is (= [:low :high]
           (sut/sort-by-kw [:low :high])))
    (is (= '(:low :high)
           (sut/sort-by-kw [:low :high])))
    (is (= '(:low :high)
           (sut/sort-by-kw '(:low :high))))
    (is (= '(:high :low)
           (sut/sort-by-kw #{:low :high})))
    (is (= '(:low :high :anything)
           (sut/sort-by-kw [:low] [:high :low :anything])))
    (is (= '(:low :high :anything)
           (sut/sort-by-kw [:low :foo] [:high :low :anything])))
    (is (= '(:low :foo :high :anything)
           (sut/sort-by-kw [:low :foo] [:high :low :anything :foo])))))
