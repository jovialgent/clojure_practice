(ns myproj.core-test
  (:require [clojure.test :refer :all]
            [myproj.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest foo-test
  (testing "(foo 1) should return 4"
    (is (= 3 (foo 1)))))
