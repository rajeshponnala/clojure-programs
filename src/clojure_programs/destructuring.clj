(ns clojure-programs.destruc
  (:gen-class))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"
   })

(def arbdest
  ((fn [[a b]] (str b a))
   [:foo :bar]))

(def ex
  ((fn [[a b c]] (str "An Oxford comma list of "a ", "
                     ""b", "
                     "and "c"."))
   ["apples" "oranges" "pears"]))

(def inLetExpre
  (let [[first-name last-name & aliases]
        (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]
    (str first-name " " last-name
         (apply str (map #(str " aka " %) aliases)))))

(def asFullArg
  (let [[first-name last-name :as full-name]
        ["Steven" "Hawking"]]
    {:original-parts full-name
     :named-parts {:first first-name :last last-name}}
    ))

(def bkpmapsbykey
  (let [{street-address :street-address city :city state :state} test-address]
    (str street-address", "city", "state)))

(def mresuccintly
  (let [{:keys [street-address city state]} test-address]
    (str street-address", "city", "state)))

(def altog
  ((fn [[first-name last-name]
       {:keys [street-address city state]}] (str first-name" "last-name", "street-address ", "city ", "state))
   ["Test" "Testerson"] test-address))
