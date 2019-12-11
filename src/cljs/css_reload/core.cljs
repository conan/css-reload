(ns css-reload.core
  (:require
    [reagent.core :as r]))

(defn page
  []
  [:div.bg
   [:h1 "Background colour change"]
   [:p "The background behind this is set by an SCSS variable in _variables.scss"]
   [:p "It should be hot-reloaded whenever the CSS is recompiled"]
   [:br]
   [:p "Start SASS compilation by running dev/sass.sh"]])

(defn mount-root []
  (when-let [app-element (.getElementById js/document "app")]
    (r/render [page] app-element)))

(defn ^:export ^:dev/after-load init []
  (mount-root))

(init)
