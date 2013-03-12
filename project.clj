(defproject compojure-sample "0.1.0-SNAPSHOT"
  :description "Koalite's Compojure Tutorial"
  :url "http://blog.koalite.com/2013/03/tutorial-compojure-i-creando-una-aplicacion-web-funcional/"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
				 [hiccup "1.0.2"]
				 [clj-json "0.5.3"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler compojure-sample.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
