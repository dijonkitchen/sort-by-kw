(ns sort-by-kw)

(defn keyword-comparator [kw-coll x y]
  (let [reverse-coll (reverse kw-coll)]
    (compare (.indexOf reverse-coll y)
             (.indexOf reverse-coll x))))

(comment
  (compare 0 1)
  (compare 0 -1)
  (keyword-comparator [:low] :high :low)
  (keyword-comparator [:low] :low :anything)
  (keyword-comparator [:low] :high :anything))

(defn sort-by-kw
  "Sorts the `coll` ordered by keywords in `sort-vec`"
  ([coll]
   (sort-by-kw [] coll))
  ([sort-vec coll]
   (sort #(keyword-comparator sort-vec %1 %2) coll)))

(defn -main []
  (println "Hola Multiverse!"))
