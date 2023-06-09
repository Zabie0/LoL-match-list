// JavaScript code for filtering match list, calculating wins, losses, and rank, and animating the list
$(document).ready(function() {
    var totalWins = 0;
    var totalLosses = 0;
    var rank = 0;
    
    $('.match-item').each(function() {
      var result = $(this).find('p:contains("Result")').text().split(':')[1].trim().toLowerCase();
  
      if (result === 'won') {
        totalWins++;
        rank += 10;
      } else if (result === 'lost') {
        totalLosses++;
        rank -= 10;
      }
    });
  
    $('#total-wins').text(totalWins);
    $('#total-losses').text(totalLosses);
    $('#rank').text(rank);
  
    $('#game-result, #game-duration, #champion').change(function() {
      var gameResult = $('#game-result').val();
      var gameDuration = $('#game-duration').val();
      var champion = $('#champion').val();
  
      $('.match-item').addClass('hidden');
  
      var filteredWins = 0;
      var filteredLosses = 0;
      var filteredRank = 0;
  
      $('.match-item').each(function() {
        var duration = $(this).find('p:contains("Duration")').text().split(':')[1].trim();
        var result = $(this).find('p:contains("Result")').text().split(':')[1].trim().toLowerCase();
        var championName = $(this).find('p:contains("Champion")').text().split(':')[1].trim().toLowerCase();
  
        var showMatch = true;
  
        if (gameResult !== 'all' && result !== gameResult) {
          showMatch = false;
        }
  
        if (gameDuration && duration > gameDuration) {
          showMatch = false;
        }
  
        if (champion && championName.indexOf(champion.toLowerCase()) === -1) {
          showMatch = false;
        }
  
        if (showMatch) {
          $(this).removeClass('hidden');
          if (result === 'won') {
            filteredWins++;
            filteredRank += 10;
          } else if (result === 'lost') {
            filteredLosses++;
            filteredRank -= 10;
          }
        }
      });
  

  
      $('.match-item.hidden').slideUp(300);
      $('.match-item:not(.hidden)').slideDown(300);
    });
  });
  