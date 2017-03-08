(function ($) {
    $(document).ready(function () {
        $('h3').click(function() {
            $(this).next().slideToggle();
        });

        $('a').click(function () {
            var req = $(this).attr('id');
            if (req === "surfaces") {
                req = "largestsurfaces";
            } else if (req === "populations") {
                req = "largestpopulations";
            } else {
                req = "";
            }
            $.get("/restservices/countries/"+req, function (data) {
                var content = "";
                $.each(data, function (i, country) {
                    content += '<tr id="row-' + i + '">';

                    content += '<td class="code">' + country.code + '</td>';
                    content += '<td class="name">' + country.name + '</td>';
                    content += '<td class="continent">' + country.continent + '</td>';
                    content += '<td class="region">' + country.region + '</td>';
                    content += '<td class="population">' + country.population + '</td>';
                    content += '<td class="surface">' + country.surface + '</td>';
                    content += '<td class="goverment">' + country.goverment + '</td>';

                    content += '</tr>';

                });
                $('#countries').html(content);
            });
        });
    });
})(jQuery);