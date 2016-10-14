(require '[cljs.build.api :as b])

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build "src"
    {:main 'pesky-select-star.core
     :output-to "out/pesky_select_star.js"
     :output-dir "out"
     :preloads ['devtools.preload]
     :verbose true})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))


