var page = require('webpage').create();
system = require('system');

/*if (system.args.length === 1)
{
  console.log('Usage: snapShot.js <some number>');
  phantom.exit();
}*/

function js_yyyy_mm_dd_hh_mm_ss ()
{
	now = new Date();

	year = "" + now.getFullYear();
	month = "" + (now.getMonth() + 1); if (month.length == 1) { month = "0" + month; }
	day = "" + now.getDate(); if (day.length == 1) { day = "0" + day; }
	hour = "" + now.getHours(); if (hour.length == 1) { hour = "0" + hour; }
	minute = "" + now.getMinutes(); if (minute.length == 1) { minute = "0" + minute; }
	second = "" + now.getSeconds(); if (second.length == 1) { second = "0" + second; }

	return year + "-" + month + "-" + day + "_" + hour + ":" + minute + ":" + second;
}

var t1 = js_yyyy_mm_dd_hh_mm_ss();
var t2 = t1.toString();
var file = t2.concat('.png');

page.open('map.html', function (status) {
    if (status !== 'success') {
        console.log('Unable to load the address!');
        phantom.exit();
    } else {
        window.setTimeout(function () {
            page.render(file);
            phantom.exit();
        }, 8000); // Change timeout as required to allow sufficient time
    }
});
