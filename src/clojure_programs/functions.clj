(ns clojure-programs.functions
  (:gen-class)
  (:use [clojure.string :only
         [lower-case split blank? split-lines]])
  (:use [clojure.java.io :only [file]]))



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
         acc []]
    (cond (= c '()) acc
          (true? (f (first c))) (recur (rest c) (conj acc (first c)) )
          :else (recur (rest c) acc)
          )))

(defn is-prime?
  [n]
  (let [x (quot n 2)]
    (loop [i 2
           res true]
      (cond (zero? (mod n i)) false
            (> i x) res
            :else (recur(inc i)res)))))

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

(defn filter2 [p coll]
  (for [ x  coll :when (p x)] x))

(defn last1 [coll]
  (loop [c coll]
    (let [[first & re] c]
      (cond (empty? re) first
            :else (recur (rest re))))))

(defn dropnthitem [n coll]
  (loop [c coll cnt 1 acc []]
    (cond (empty? c) acc
          (zero? (mod cnt n)) (recur (rest c) (inc cnt) acc)
          :else (recur (rest c) (inc cnt) (conj acc (first c))))))

(defn map-construct [keys values]
  (loop [k keys v values acc {}]
    (cond (or (empty? k) (empty? v)) acc
          :else (recur (rest k) (rest v) (conj acc [(first k) (first v)])))))

(defn map-defaults [val keys]
  (loop [k keys  acc {}]
    (cond (empty? k) acc
          :else (recur (rest k) (conj acc [(first k) val])))))


(defn max1 [coll]
  (reduce (fn [x y]
            (if (> x y) x y)) coll))

(defn is-perfect? [n]
  (= n (reduce (fn [x y] (if (zero? (mod n y)) (+ x y) x)) (range n))))

(defn split-line [line]
  (vec (split (clojure.string/replace line #"[.,]" "") #"\s+")))

(defn get-lines [filename]
  (remove blank? (split-lines (slurp (file "/home/rajesh/"filename)))))

(defn get-words [filename]
  (mapcat split-line  (get-lines filename)))

(defn word-count [filename]
  (count (get-words filename)))

(defn word-frequency [word filename]
  (let [w (lower-case word)]
    (count (filter (fn [w1] (= w (lower-case w1))) (get-words filename)))))

(defn grep1 [word filename]
  (let [w (lower-case word)]
    (into {} (filter (fn [[k v]] (isword-contains? w (lower-case v))) (zipmap (range) (get-lines filename))))))

(defn index [filename]
  (reduce (fn [x w] ( conj x [w (keys (grep1 w filename))])) {} (get-words filename)))

(defn isword-contains? [word line]
  (let [w (lower-case word) coll (split-line line) ]
    (loop [c coll]
      (cond (empty? c) false
            (= w (first c)) true
            :else (recur (rest c))))))



(defn unique [coll]
  (loop [c coll res [] buf []]
    (let [ f (first c)]
      (cond (empty? c) res
            (= -1 (.indexOf buf f))
            (recur (rest c) (conj res f) (conj buf f))
            :else
            (recur (rest c) res buf)))))

(defn groupby [f coll]
  (loop [c coll acc {}]
    (let [e (first c)]
      (cond (empty? c) acc
            (contains? acc (f e))
            (recur (rest c) (assoc acc (f e) (conj (acc (f e)) e)))
            :else
            (recur (rest c) (assoc acc (f e) (vector e)))))))

(defn lcm [n1 n2]
  (loop [cnt (if (< n1 n2) n1 n2)]
    (cond (and (zero? (mod cnt n1)) (zero? (mod cnt n2))) cnt
          :else (recur (inc cnt)))))

(defn lcm2 [coll]
  (reduce lcm 1  coll))
