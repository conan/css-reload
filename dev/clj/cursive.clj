(require
  '[shadow.cljs.devtools.api :as api]
  '[shadow.cljs.devtools.server :as server])
(server/start!)
(api/watch :app)
(api/repl :app)
