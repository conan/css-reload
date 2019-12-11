# css-reload

A small repro project for a problem with hot-reloading CSS.

Install npm deps:

    npm install

Run the web server:

    lein repl
    (go)

Run shadow-cljs:

    npx shadow-cljs watch app

To run from Cursive, create a local Clojure REPL run configuration that uses clojure.main and set the Parameters field 
to be:
 
    dev/clj/cursive.clj

Run SASS:

    npx node-sass resources/sass -wo resources/public/css/compiled --importer node_modules/node-sass-import

[shadow-cljs.edn](shadow-cljs.edn) contains `:watch-dir` set to `resoures/public`, but when CSS is compiled to 
`resources/public/css/compiled/css-reload.css` it isn't hot-reloaded.  