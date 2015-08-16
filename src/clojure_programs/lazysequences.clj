(ns clojure-programs.lazyseq
  (:gen-class))

(def genSeq
  (range 1 5))

(def seqatbeg
  (range 5))

(def take10
  (take 10 (range 100)))

(def drop95
  (drop 95 (range 100)))

(def take20fromlazyseq
  (take 20 (iterate inc 1)))

(def repeatex
  (repeat 10 :a))
