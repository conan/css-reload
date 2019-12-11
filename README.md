# css-reload

A small repro project for a problem with hot-reloading CSS.

Run the web server:

    lein repl
    (go)

Run shadow-cljs:

    npx shadow-cljs watch app

Run SASS:

    npx node-sass resources/sass -wo resources/public/css/compiled --importer node_modules/node-sass-import

[shadow-cljs.edn](shadow-cljs.edn) contains `:watch-dir` set to `resoures/public`, but when CSS is compiled to 
`resources/public/css/compiled/css-reload.css` it isn't hot-reloaded.  