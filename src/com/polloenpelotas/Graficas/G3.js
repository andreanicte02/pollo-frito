var data = [{
x: ["gato", "baca", "idiota"],
y: [20, 14, 23],
type: 'bar' 
}];  
 
var layout = { 
height: 600, 
width: 600, 
title: "titulo",
xaxis:  {title: "etiquetax"},
yaxis:  {title: "etiquetay"},
}; 
 
Plotly.newPlot('G3', data, layout);
