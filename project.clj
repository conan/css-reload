(defproject css-reload "0.1.0-SNAPSHOT"
  :min-lein-version "2.7.1"
  :dependencies [[clj-http "3.10.0"]
                 [cljs-http "0.1.46"]
                 [com.google.javascript/closure-compiler-unshaded "v20190909"]
                 [com.taoensso/timbre "4.10.0"]
                 ;[environ "1.1.0"]
                 [http-kit "2.3.0"]
                 [metosin/reitit "0.3.10"]
                 [metosin/ring-http-response "0.9.1"]
                 ;[orchestra "2019.02.06-1"]
                 [org.clojure/clojure "1.10.1"]
                 [org.clojure/google-closure-library "0.0-20190213-2033d5d9"]
                 ;[org.clojure/tools.reader "1.3.2"]
                 ;[org.eclipse.jetty.websocket/websocket-server "9.4.20.v20190813"]
                 ;[org.eclipse.jetty.websocket/websocket-servlet "9.4.20.v20190813"]
                 ;[org.eclipse.jetty/jetty-server "9.4.20.v20190813"]
                 [reagent/reagent "0.8.1"]
                 ;[ring/ring-core "1.8.0"]
                 [ring/ring-defaults "0.3.2"]
                 [thheller/shadow-cljs "2.8.80"]]
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.11"]
                                  [com.google.javascript/closure-compiler-unshaded "v20190909"]
                                  [org.clojure/clojurescript "1.10.520"]
                                  [org.clojure/core.async "0.4.500"]
                                  [org.clojure/tools.namespace "0.3.1"]]
                   :repl-options {:init-ns css-reload.core
                                  :timeout 120000}
                   :source-paths ["dev/cljs"]
                   :resource-paths ["target"]}
             :rebel {:dependencies [[com.bhauman/rebel-readline-cljs "0.1.4"]]}
             :uberjar {:aot :all}}
  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["resources"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :main css-reload.core
  :uberjar-name "css-reload.jar"
  :aliases {"shadow:dev" ["with-profile" "dev" "do"
                          ["clean"]
                          ["run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]]
            "shadow:prod" ["do"
                           ["clean"]
                           ["run" "-m" "shadow.cljs.devtools.cli" "release" "app"]]})
