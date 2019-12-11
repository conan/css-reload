(ns css-reload.core
  "Entry point for production Uberjars"
  (:require
    [clojure.java.io :as io]
    [org.httpkit.server :as server]
    [reitit.ring :as rr]
    [ring.middleware.defaults :as defaults :refer [wrap-defaults]]
    [ring.util.http-response :as response]))

(defn index
  [_request]
  (-> "public/index.html"
      io/resource
      slurp
      response/ok
      (assoc-in [:headers "content-type"] "text/html")))

(defn app
  []
  (rr/ring-handler
    (rr/router
      ["/" {:middleware [[wrap-defaults defaults/site-defaults]]
            :get index}])
    (-> (rr/create-default-handler)
        (wrap-defaults defaults/site-defaults))))

(defonce server (atom nil))

(defn go
  []
  (println "Starting web server at http://localhost:4000")
  (reset! server (server/run-server (app) {:port 4000}))
  :ready)

(defn reset
  []
  (println "Stopping web server")
  (when @server (@server))
  (go))
