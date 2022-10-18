var pagenumber = 1;

            function writeVar(variable){
                document.write(variable)
            }

            function setPageNumber(number){
              pagenumber += number;
              if(pagenumber >= 1){
                document.getElementById('pageNumber').innerHTML = pagenumber;
              }
            }

            function getFirstPage(){
              pagenumber = 1;
              document.getElementById('pageNumber').innerHTML = pagenumber;
            }

            function getLastPage(){

            }

            function myFunction() {
                document.getElementById("myDropdown").classList.toggle("show");
            }