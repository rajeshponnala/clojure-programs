(ns clojure-programs.rec
  (:gen-class))

(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n n
         acc true]
    (if (= n 0 )
      acc
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  (loop [coll coll
         reversed ()]
    (if (= () coll)
      reversed
      (recur (rest coll) (cons (first coll) reversed)))))

(defn factorial [n]
  (loop [n n
         acc 1]
    (if (= n 0)
      acc
      (recur (dec n) (* n acc)))))
