(ns sort-by-kw-test
  (:require
   [clojure.test :refer [deftest
                         testing
                         is]]
   [sort-by-kw :as sut]))

(deftest sanity
  (testing "equality"
    (is (= 1 1))))
