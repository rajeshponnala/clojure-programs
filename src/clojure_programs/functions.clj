(ns clojure-programs.functions
  (:gen-class))

(defn multiply-by-ten
  [n]
  (* 10 n))

(defn square [n] (* n n))

(def inlineFunc
  ((fn [n] (* 10 n)) 2))

(def anonyFun
  (#(+ %1 %2 %3) 4 5 6))

(def highOrdFunc
  ((fn [f] (f 5))
   (fn [n] (* n n))))

(def highOrdExistFunc
  ((fn [f] (f 5)) square))

(defn transform
  [f data]
  (if (first data)
    (cons (f (first data))
          (transform f (rest data)))
    (list)))

(defn expand
  [f x count]
  (if (pos? count)
    (cons x (expand f (f x) (dec count)))
    (list)
    ))

(defn filter1 [f coll]
  (loop [c coll
         acc '()]
    (cond (= c '()) acc
          (= true (f (first c))) (recur (rest c) (cons (first c) acc) )
          :else (recur (rest c) acc)
          )))
