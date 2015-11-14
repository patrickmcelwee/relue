var GridTraverser = function() {};

GridTraverser.prototype.countPaths = function(n) {
  var x = 1;
  entrySteps = [1];
  while (x <= n) {
    oldEntrySteps = entrySteps;
    entrySteps = [];
    entrySteps.push(2 * this.sum(oldEntrySteps));
    i = x - 1;
    while (i >= 0) {
      entrySteps.push(this.sum(oldEntrySteps));
      oldEntrySteps.shift();
      i -= 1;
    }
    x += 1;
  }
  return entrySteps[0];
};

GridTraverser.prototype.sum = function(array) {
  return array.reduce(function(acc, n) {
    return acc + n;
  }, 0);
};

module.exports = GridTraverser;
