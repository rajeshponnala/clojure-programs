(ns clojure-programs.seqcomp
  (:gen-class))

(def seqcompex
  (for [index (range 6)] index))

(def emlmapseqcomp
  (for [i (range 6)] (* i i)))

(def filterseqcomp
  (for [x (range 10) :when (odd? x)] x))

(def squareodd
  (for [x (range 10) :when (odd? x)] (* x x)))
