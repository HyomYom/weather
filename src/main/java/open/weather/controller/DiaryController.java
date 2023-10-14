package open.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import open.weather.domain.Diary;
import open.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @ApiOperation(value = "Read Save diary to DB using diary text and weather info", notes = "This is notes")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "Date Format yyyy-MM-dd", example = "2023-01-01")
                     LocalDate date, @RequestBody String text) {
        diaryService.createDiary(date, text);

    }

    @ApiOperation(value = "Get all diary data for the selected date.", notes = "This is notes")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.readDiary(date);
    }

    @ApiOperation(value = "Get all diary data for the selected period.", notes = "This is notes")
    @GetMapping("read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "Date Format yyyy-MM-dd", example = "2023-01-01") LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "Date Format yyyy-MM-dd", example = "2023-01-01") LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation(value = "Update diary data.", notes = "This is notes")
    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "Date Format yyyy-MM-dd", example = "2023-01-01")
                     LocalDate date,
                     @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @ApiOperation(value = "Delete diary data for the selected date.", notes = "This is notes")
    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "Date Format yyyy-MM-dd", example = "2023-01-01")
                     LocalDate date) {
        diaryService.deleteDiary(date);
    }

}
