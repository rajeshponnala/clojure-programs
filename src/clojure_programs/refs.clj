(ns clojure-programs.refs
  (:gen-class))

(def the-world (ref "hello"))

(def derefworld
  (deref the-world))

(def refset
  (do (dosync (ref-set the-world "better"))
      @the-world))
(def alt
  (let [exclamator (fn [x] (str x "!"))]
    (dosync
     (alter the-world exclamator)
     (alter the-world exclamator)
     (alter the-world exclamator)
     ) @the-world))

(def intransact
  (do
    (dosync (ref-set the-world 0))
    @the-world))
