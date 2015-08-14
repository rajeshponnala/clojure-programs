(ns clojure-programs.maps
  (:gen-class))

(def createMap
  (hash-map))

(def countMap
  (count (hash-map) ))

(def lookup
  (get {:a 1 :b 2} :b))
