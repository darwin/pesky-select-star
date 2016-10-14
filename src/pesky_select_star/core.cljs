(ns pesky-select-star.core
  (:require-macros [com.rpl.specter :refer [providepath declarepath must multi-path if-path select select-first path]])
  (:require [com.rpl.specter :as s :refer [continue-then-stay ALL]]))

(enable-console-print!)

; this was copy&pasted from specter tests, fails too

(declarepath MyWalker)

(providepath MyWalker
             (s/if-path vector?
                        (s/if-path [s/FIRST #(= :abc %)]
                                   (s/continue-then-stay s/ALL MyWalker)
                                   [s/ALL MyWalker])))


(let [r (select [MyWalker s/ALL number?]
                [:bb [:aa 34 [:abc 10 [:ccc 9 8 [:abc 9 1]]]] [:abc 1 [:abc 3]]])]
  (.log js/console "!" r))

; ------------------------------------------------------------------------------------------------------------------------

(def data (quote {:tag         "div",
                  :class       "widget vbox",
                  :shadow-root {:tag      "div"
                                ;...
                                :children ()}
                  :children    ({:tag      "div",
                                 :class    "list-item selected",
                                 :children ({:tag     "div",
                                             :class   "subtitle",
                                             :content "core.cljs:10",
                                             :title   "http://localhost:9080/.compiled/tests/dirac/tests/scenarios/breakpoint/core.cljs:10"}
                                             {:tag     "div",
                                              :class   "title",
                                              :content "breakpoint-demo",
                                              :title   "dirac.tests.scenarios.breakpoint.core/breakpoint-demo"})}
                                 ; ...
                                 {:tag      "div",
                                  :class    "list-item",
                                  :children ({:tag     "div",
                                              :class   "subtitle",
                                              :content "notifications.cljs:53",
                                              :title   "http://localhost:9080/.compiled/tests/dirac/automation/notifications.cljs:53"}
                                              {:tag     "div",
                                               :class   "title",
                                               :content "process-event!",
                                               :title   "dirac.automation.notifications/process-event!"})})}))

; this is minimal failing case on my data

(declarepath RepWalker)

(providepath RepWalker
             (continue-then-stay
               ALL
               RepWalker))

(let [res (select RepWalker data)]
  (.log js/console res))
