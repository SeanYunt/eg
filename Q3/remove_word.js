module.exports = {
 removeWordFromSentence: function (sentence = "Hello there world.", word = "there") {
   var result = sentence.replace(word, "");
   return result;
 }
};