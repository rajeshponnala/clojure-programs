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
  (keep-indexed #(if (not (zero? (mod (+ %1 1) n))) %2) coll))

(defn seqofpairs [vc]
  (map vector vc (range)))

;;A balanced number is one whose component digits have the same sum on the left and right halves of the number. Write a function which accepts an integer n, and returns true iff n is balanced.
(defn balance-number [n]
  (let [ve (vec (seq (str n))) cnt (count ve)
        nu (quot cnt 2) midpos (if (even? cnt) nu (inc nu)) ]
    (cond (= cnt 1) true
          (= cnt 2) (= (first ve) (last ve))
          :else (= (reduce (fn [a c] (+ a (read-string (str c)))) 0 (subvec ve 0 (- midpos 1)))
                   (reduce (fn [a c] (+ a (read-string (str c)))) 0 (subvec ve midpos))))))

;;Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
(defn noofocc [coll]
  (reduce (fn [a e] ( if (contains? a e) (update-in a [e] inc)
                        (assoc a e 1))) {} coll))
