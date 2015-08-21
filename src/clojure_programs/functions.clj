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

(defn is-prime?
  [n]
  (let [x (quot n 2)]
    (loop [i 2
           res true]
      (cond (zero? (mod n i)) false
            (> i x) res
            :else (recur (inc i) res) ) ) ) )

(defn n-primes
  [n]
  (take n (filter is-prime? (iterate inc 1))))

(defn get-char-frequency
  [c word]
  (let [s (seq word)]
    (loop [w s
           cnt 0]
      (cond (nil? (first w)) cnt
            (= c (first w)) (recur (rest w) (inc cnt))
            :else (recur (rest w) cnt)))))
