var func = require('../remove_word');
var assert = require('assert');

describe('remove word from sentence', function() {
  describe('happy path', function() {
    it('simple case', function() {
      assert.equal(func.removeWordFromSentence("Hello big world", "big"), "Hello  world");
    });
  });
  describe('edge case', function() {
    it('longer with punctuation', function() {
      assert.equal(func.removeWordFromSentence("To determine a floodplain boundary, we first identify a “storm event” that concerns us. ", "floodplain"), "To determine a  boundary, we first identify a “storm event” that concerns us. ");
    });
  });
  describe('edge case', function() {
    it('single word', function() {
      assert.equal(func.removeWordFromSentence("Go.", "Go"), ".");
    });
  });  
  describe('i18n', function() {
    it('traditional Chinese', function() {
      assert.equal(func.removeWordFromSentence("我不餓。", "不"), "我餓。");
    });
  });
  describe('i18n', function() {
    it('French', function() {
      assert.equal(func.removeWordFromSentence("Je n'ai pas faim.", "pas "), "Je n'ai faim.");
    });
  });
});