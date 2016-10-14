(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'pesky-select-star.core
   :output-to "out/pesky_select_star.js"
   :preloads ['devtools.preload]
   :output-dir "out"})
