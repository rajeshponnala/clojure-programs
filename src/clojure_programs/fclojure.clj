(ns clojure.4clojure
  (:gen-class)
  (:use [clojure.string :only [join split]])
  (:use [clojure.core :only [filter]])
  (:use [clojure.set :only [union difference]]))

(defn big-divide [n p1 p2]
  (reduce (fn [x y] (cond (or (zero? (mod y p1))  (zero? (mod y p2))) (+ x y)
                         :else x)) (range n)))

(defn fil-perfec-squares [s]
  (join ","  (filter (fn [x] (loop [n (read-string x) cnt 1]
                              (cond (= n cnt) false
                                    (= n (* cnt cnt)) true
                                    :else (recur n (inc cnt))))) (split s #","))))

(defn gcd [a b]
  (if (zero? b) a
      (recur b (mod a b))))

(defn symm-diff [s1 s2]
  (union (difference s1 s2) (difference s2 s1)))

(defn reverse-interleave [coll n]
  (for [i (range n)] (take-nth n (drop i coll))))

(defn dropnthitem [n coll]
  (keep-indexed #(if (not (zero? (mod %1 n))) %2) coll))
