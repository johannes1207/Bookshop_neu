/* global QUnit */
QUnit.config.autostart = false;

sap.ui.getCore().attachInit(function () {
	"use strict";

	sap.ui.require([
		"com/sap/bookstoreTA/com/sap/bookstoreTA/test/unit/AllTests"
	], function () {
		QUnit.start();
	});
});