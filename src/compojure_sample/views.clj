(ns compojure-sample.views
  (:use hiccup.page)
  (:use hiccup.element))
			
(defn index [hero-names]
  (html5 
  
    [:head
	  (include-css "/public/css/style.css")
	  (include-js "/public/js/jquery-1.9.1.min.js")
	  (include-js "/public/js/view.index.js")
	  [:title "Mega Facts"]]
	  
	[:body
	  [:div#container
	  
	    [:div#header
		  [:h1 "Mega Facts"]]
		  
		[:div#content
		  [:div#left-column.column
		    [:h2 "Elige tu héroe"]
			[:ul#heroes
			  (for [name hero-names]
			    [:li.hero-name (link-to "#" name)])]]
		  [:div#right-column.column
		    [:h2 "Facts"]
			[:ul#facts]
			[:label {:for "new-fact"} "Añadir nuevo fact:"]
			[:textarea#new-fact]
			[:a#add-new-fact {:href "#"} "Añadir"]]]
			
		[:div#footer
		  [:a {:href "http://blog.koalite.com"}]]]]))