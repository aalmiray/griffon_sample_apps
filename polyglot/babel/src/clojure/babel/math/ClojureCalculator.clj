(ns babel.math.ClojureCalculator
  (:gen-class
   :implements [babel.math.Calculator]))

(defn -add [this a b] (+ a b))
