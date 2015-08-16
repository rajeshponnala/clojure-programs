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
