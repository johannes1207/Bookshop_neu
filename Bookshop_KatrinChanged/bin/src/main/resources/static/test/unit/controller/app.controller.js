/*global QUnit*/

sap.ui.define([
	"com/sap/bookstoreTA/com/sap/bookstoreTA/controller/app.controller"
], function (Controller) {
	"use strict";

	QUnit.module("app Controller");

	QUnit.test("I should test the app controller", function (assert) {
		var oAppController = new Controller();
		oAppController.onInit();
		assert.ok(oAppController);
	});

});