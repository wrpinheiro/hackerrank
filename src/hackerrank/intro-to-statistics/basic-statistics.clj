(ns hackerrank.intro-to-statistics.basic-statistics
  (:require [clojure.core]),
  (:require [clojure.math.numeric-tower :as math]))

(defn mean
  [integers]
  (/ (reduce + integers) (count integers)))

(defn median
  [sorted-integers]
  (let [size (count sorted-integers)]
    (if (odd? size)
      (get sorted-integers (int (/ size 2)))
      (let [median-right (int (/ size 2))]
        (mean (subvec sorted-integers (dec median-right) (inc median-right)))))))

(defn count-equal-elements
  [integers]
  (reduce (fn [map element]
    (assoc map element (inc (get map element 0)))) {} integers))

(defn mode
  [integers]
  (let [occurrences (count-equal-elements integers)
    max-value (apply max (vals occurrences))
    modes (map key (filter #(= max-value (val %)) occurrences))]
    (println occurrences)
    (println max-value)
    (println modes)
    (apply min modes)))

(defn sd
  [integers]
  (let [m (mean integers)
    subtractions (map #(- % m) integers)
    powers (map #(math/expt % 2) subtractions)]
    (print "sub => " )
    (println subtractions)
    (println (float m))
    (println powers)))


(defn standard-deviation
  [integers]
  (let [m (mean integers)
    powers (map #(math/expt (- % m) 2) integers)
    sum (+ powers)]
    (println powers)
    (/ (math/sqrt sum) (count integers))))

(defn output-value
  [value]
  (println (format "%.1f" (float value))))

(def n (read-line))

(let [input (read-string (str "[" (read-line) "]"))]
  (let [sorted-integers (into [] (sort input))]
    (output-value (mean input))
    (output-value (median sorted-integers))
    (output-value (mode sorted-integers))
    (output-value (standard-deviation input))))
