(ns clojure-programs.atoms
  (:gen-class))

(def atomic-clock (atom 0))

(def swap1
  (do
    (swap! atomic-clock inc)
    @atomic-clock))
