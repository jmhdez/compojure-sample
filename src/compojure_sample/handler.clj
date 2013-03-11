(ns compojure-sample.handler
  (:use compojure.core)
  (:use hiccup.page)
  (:use hiccup.element)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn the-page []
  (h/html5 
    [:head
	  [:title "Mega Facts"]]
	[:body
	  [:div#container
	    [:div#header
		  [:h1 "Mega Facts"]]
		[:div#content
		  [:div#left-column.column
		    [:h2 "Elige tu héroe"]
			[:ul#heroes
			  [:li.hero-name
			    (link-to "#" "Chuck Norris")]]]
		  [:div#right-column.column
		    [:h2 "Facts"]
			[:ul#facts]
			[:label {:for "new-fact"} "Añadir nuevo fact:"]
			[:textarea#new-fact]
			[:a#add-new-fact {:href "#"} "Añadir"]]]
		[:div#footer
		  [:a {:href "http://blog.koalite.com"}]]]]))

(defroutes app-routes
  (GET "/" [] (the-page))
  (route/files "/public" {:root "public"})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
