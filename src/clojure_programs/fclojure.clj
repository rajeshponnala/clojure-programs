(ns clojure.4clojure
  (:gen-class)
  (:use [clojure.string :only [join split]])
  (:use [clojure.core :only [filter]]))

(defn big-divide [n p1 p2]
  (reduce (fn [x y] (cond (or (zero? (mod y p1))  (zero? (mod y p2))) (+ x y)
                         :else x)) (range n)))

(defn fil-perfec-squares [s]
  (join ","  (filter (fn [x] (loop [n (read-string x) cnt 1]
                              (cond (= n cnt) false
                                    (= n (* cnt cnt)) true
                                    :else (recur n (inc cnt))))) (split s #","))))
